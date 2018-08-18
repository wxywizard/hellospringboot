package com.wxywizard.service;

import com.wxywizard.dao.repositoryone.GirlRepository;
import com.wxywizard.domain.domainone.Girl;

import com.wxywizard.enums.ResultEnum;
import com.wxywizard.exception.GirlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author: wangxy
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    //统一异常处理测试
    public void getAge(String id) throws Exception{

        Girl girl1 = new Girl();
        girl1.setId(id);
        Example<Girl> example = Example.of(girl1);
        Optional<Girl> girl = girlRepository.findOne(example);
        Integer age = girl.get().getAge();
        if (age<10){
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if (10<= age && age< 16){
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }else {
            throw new GirlException(ResultEnum.UNKONW_ERROR);
        }



    }
}
