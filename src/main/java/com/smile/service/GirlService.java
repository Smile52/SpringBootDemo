package com.smile.service;

import com.smile.GirlException;
import com.smile.domain.Girl;
import com.smile.enums.ResultEnums;
import com.smile.repository.GirlPageRepository;
import com.smile.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yaojiulong on 2017/7/26.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;



    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age<10){
            throw new GirlException(ResultEnums.PAIMARY_SCHOOL
            );
        }else if (age<18 && age>10){
            throw new GirlException(ResultEnums.MIDDLE_SCHOOL );
        }

    }

}
