package com.smile.controller;

import com.smile.domain.Girl;
import com.smile.domain.Result;
import com.smile.repository.GirlRepository;
import com.smile.service.GirlService;
import com.smile.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by yaojiulong on 2017/7/25.
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查找全部
     * @return
     */
    @GetMapping(value = "/girls")
    public Result<List<Girl>> girlList(){
        return  ResultUtil.success(girlRepository.findAll()) ;
    }

    /**
     * 根据id查 找
     * @param id
     * @return
     */
    @GetMapping(value = "/girl/{id}")
    public Girl findById(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

  /*  *//**
     * 添加
     * @param httpServletRequest
     * @return
     *//*
    @PostMapping(value = "/girl")
    public Girl girlAdd(HttpServletRequest httpServletRequest){
        String cupSize =httpServletRequest.getParameter("cupSize");
        String age = httpServletRequest.getParameter("age");
        Girl girl = new Girl();
        girl.setAge(Integer.valueOf(age));
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }*/

    /**
     * 添加，，表单验证，小于18岁的不给于通过
     * @return
     */
    @PostMapping(value = "/girl")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(0, bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setAge(Integer.valueOf(girl.getAge()));
        girl.setCupSize(girl.getCupSize());
        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 根据id更新
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping(value = "/girl/{id}")
    public Girl updateGirl(@RequestParam("id") Integer id, @RequestParam("cupSize") String cupSize,
                            @RequestParam("age") Integer age, @RequestParam("money") double money){
        Girl girl =new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girl.setMoney(money);
        return girlRepository.save(girl);

    }

    @GetMapping(value = "/girl/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id)throws Exception{
        girlService.getAge(id);

    }



}
