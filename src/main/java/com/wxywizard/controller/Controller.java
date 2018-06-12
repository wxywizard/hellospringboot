package com.wxywizard.controller;


import com.wxywizard.dao.repositoryone.GirlRepository;
import com.wxywizard.dao.repositorytwo.GirlRepositorytwo;
import com.wxywizard.domain.domainone.Girl;
import com.wxywizard.domain.domaintwo.GirlTwo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class Controller {

    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlRepositorytwo girlRepositorytwo;

    @RequestMapping(value = "/test/{id}",method = RequestMethod.GET)
    public String test(@PathVariable(value = "id",required = true) String id){

        log.info("id==={}",id);
        return id;
    }

    /**
     * 添加对象
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value = "/girls")
    public Girl saveGirl(@RequestParam(value = "cupSize",required = true) String cupSize,
                          @RequestParam(value = "age",required = true) Integer age){

        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 查询对象
     * @return
     */
    @GetMapping(value = "/girlsone")
    public List<Girl> listGirl(){

        return girlRepository.findAll();
    }

    /**
     * 查询对象
     * @return
     */
    @GetMapping(value = "/girlstwo")
    public List<GirlTwo> listGirl2(){

        return girlRepositorytwo.findAll();
    }

    /**
     * 查询单一对象
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Optional<Girl> girlFindOne(@PathVariable(value = "id") String id){
        //springboot2.0新特性
        //直接用findById查找
        //return  girlRepository.findById(id);
        //构通Example查找
        Girl girl = new Girl();
        girl.setId(id);
        Example<Girl> example = Example.of(girl);
        return girlRepository.findOne(example);
        //return girlRepository.getOne(id);
        //return girlRepository.findById(id).get();
    }
    /**
     * 更新对象
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Girl updateGirl(@PathVariable(value = "id") String id,
                            @RequestParam(value = "cupSize") String cupSize,
                            @RequestParam(value = "age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRepository.save(girl);
    }

    /**
     * 删除一个对象
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void deleteGirl(@PathVariable(value = "id") String id){

        Girl girl = new Girl();
        girl.setId(id);
        girlRepository.delete(girl);
    }

}
