package org.example.springboot.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.springboot.domain.User.*;
import org.example.springboot.domain.UsersData.FavPressRepository;
import org.example.springboot.domain.UsersData.Fav_Press;
import org.example.springboot.dto.User.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.example.springboot.util.UtilSet.getRandomCode;

@Log4j2
@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private UserAuthRepository userAuthRepository;
    private UserConfigRepository userConfigRepository;
    private FavPressRepository favPressRepository;

    @Transactional
    public Long saveUser(UserDTO userDTO) {
        User user;
        try{
            user = userRepository.save(userDTO.toEntity());

            userAuthRepository.save(new UserAuthDTO(user, valiCode(20), false, "0").toEntity());
            userConfigRepository.save(new UserConfigDTO(user, true).toEntity());
        } catch(Exception e) {
            e.printStackTrace();
            return 0L;
        }
        return user.getId();
    }

    public String valiCode(int length) {
        String code = getRandomCode(length);
        if(userAuthRepository.countByCode(code) > 0) {
            valiCode(length);
        }
        return code;
    }

    @Transactional
    public User getUser(String uid) { return userRepository.findByUid(uid); }

    @Transactional
    public int chkUser(String data, String type) {
        if(type.equals("id")) {return userRepository.countByUid(data);}
        else {return userRepository.countByEmail(data);}
    }

    @Transactional
    public int login(UserLoginDTO userLoginDTO) {
        try {
            log.info(userRepository.countByUidAndPassword(userLoginDTO.getId(), userLoginDTO.getPw()));
            return userRepository.countByUidAndPassword(userLoginDTO.getId(), userLoginDTO.getPw());
        } catch (Exception e) {
            return 0;
        }
    }

    @Transactional
    public String getSalt(String data) {
        try {
            return userRepository.findByUid(data).getSalt();
        } catch (Exception e) {
            return "0";
        }
    }

    @Transactional
    public String getAuth(String data) {
        try{
            User user;
            if(data.contains("@")) {
                user = userRepository.findByEmail(data);
            } else {
                user = userRepository.findByUid(data);
            }
            return userAuthRepository.findByUser(user).getCode();
        } catch (Exception e) {
            return "what the FUck";
        }
    }

    @Transactional
    public String getEmail(String data) {
        try{
            return userRepository.findByUid(data).getEmail();
        } catch (Exception e) {
            return "None";
        }
    }

    @Transactional
    public Boolean chkCode(String code) {
        if(code.equals("0")) { return false; };
        try{
            userAuthRepository.codeSetZero(code);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Transactional
    public List<String> getFavPress(String id) {
        try {
            User user = userRepository.findByUid(id);
            List<Fav_Press> favPresses = favPressRepository.findAllByUser(user);
            List<String> result = new ArrayList<>();
            for(int i = 0; i < favPresses.size(); i++) {
                result.add(favPresses.get(i).getPress().getName());
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            List<String> result = new ArrayList<>();
            return result;
        }
    }

    @Transactional
    public boolean checkSet(String id) {
        User user = userRepository.findByUid(id);
        return userConfigRepository.findByUser(user).getComment();
    }

    @Transactional
    public void commentSet(String id) {
        try {
            User user = userRepository.findByUid(id);
            boolean comment = userConfigRepository.findByUser(user).getComment();
            if (comment) {
                userConfigRepository.setComment(user.getId(), false);
            } else {
                userConfigRepository.setComment(user.getId(), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public String findId(String email) {
        return userRepository.findByEmail(email).getUid();
    }

    @Transactional
    public String findPw(String email, String id) {
        User user = userRepository.findByEmailAndUid(email, id);
        User_Auth user_auth = userAuthRepository.findByUser(user);
        String code = getRandomCode(6);
        user_auth.update(code);
        return code;
    }

    @Transactional
    public Boolean findPwAuth(String code) {
        log.info(code);
        int cntAuth = userAuthRepository.countByPwCode(code);
        return cntAuth > 0;
    }

    @Transactional
    public Boolean changePw(UserPwDTO userPwDTO) {
        try {
            User user = userRepository.findByEmail(userPwDTO.getEmail());
            user.update(userPwDTO);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
