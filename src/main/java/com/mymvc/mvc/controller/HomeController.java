package com.mymvc.mvc.controller;

import com.mymvc.mvc.dao.*;
import com.mymvc.mvc.model.Entity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class HomeController {


    @GetMapping("/")
    public String index(){
        return "hello lhoussaine";
    }

    @PostMapping(path = "/hssini")
    public  RegestrationDto aa(@RequestBody RegestrationDto form){
        return form;
    }

    @GetMapping(path = "/ana")
    public HashMap<String, Object> ana(){
        HashMap<String, Object> obj = new HashMap<>();
        HashMap<String, Object> subobj = new HashMap<>();
        List<ContactDto> contacts = new ArrayList<>();

        contacts.add(new ContactDto("work", "042637"));
        contacts.add(new ContactDto("home", "1212434"));
        contacts.add(new ContactDto("my", "9972636"));



        subobj.put("work", "test work addres");
        subobj.put("home", "my home in safi xari3 dari hana");

        obj.put("username", "hssini lhoussaine");
        obj.put("email", "aa@gmail.com");
        obj.put("password", "1234");
        obj.put("addres", subobj);
        obj.put("contact", contacts);
        return obj;
    }

    @GetMapping(path = "/user")
    public  List<UserDto> user(){

        List<UserDto> userList = new ArrayList<>();

        List<AddressDto> addressDtoList = new ArrayList<>();

        addressDtoList.add(new AddressDto("marroko","tanger", "12"));
        addressDtoList.add(new AddressDto("teness","marina", "11"));
        addressDtoList.add(new AddressDto("dobay","kantara", "15"));

        List<AddressDto> addressDtoList_1 = new ArrayList<>();

        addressDtoList_1.add(new AddressDto("ljlh","kkgyuf", "12"));
        addressDtoList_1.add(new AddressDto("hhfj","jvjjv", "11"));
        addressDtoList_1.add(new AddressDto("jhjhgjh","kjklj", "15"));

        List<AddressDto> addressDtoList_2 = new ArrayList<>();

        addressDtoList_2.add(new AddressDto("ufjj","hgkjb", "12"));
        addressDtoList_2.add(new AddressDto("iugu","uguigg", "11"));
        addressDtoList_2.add(new AddressDto("res","rress", "15"));

        userList.add(new UserDto("lhoussaine", "hssini", "463427637","man",addressDtoList));
        userList.add(new UserDto("aman", "momni", "325672333","man", addressDtoList_1));
        userList.add(new UserDto("kayna", "karoula", "6787293","women", addressDtoList_2));

        return userList;
    }


    @PostMapping("/test_json_array")
    public UserDto test_post(@RequestBody UserDto user){
        user.getAddressDtoList().forEach(p->{
            System.out.println(p.getCity());
            System.out.println(p.getCountry());
            System.out.println(p.getStreet());
        });
        return user;
    }

    @Autowired
    private TestDao testDao;

    @GetMapping("/testgetname")
    public String testget(){
        return testDao.getName();
    }



    @GetMapping("/getUser")
    public  Iterable<TestEntity>   guser(){
        return testDao.guser();
    }
    @GetMapping("/getUser1")
    public  List<TestEntity>   guser_1(){
        return testDao.guser_1();
    }

    @GetMapping("/lho")
    public void nextt(){
        Integer x = 12;
        Integer y = null;
        Optional<Integer> optionalInteger = Optional.of(x);
        Optional<Integer> optionalIntegery = Optional.ofNullable(y);

        if (optionalIntegery.isPresent()){
            System.out.println("y ==== is present ====> "+y);
        }else {
            System.out.println("x ==== is present ====> "+x);
            System.out.println("y ==== is not present");
        }
        y =optionalInteger.orElse(x);
        System.out.println("x ==== is present ====> "+x);
        System.out.println("orElse(x) ====> "+y);
    }
    @GetMapping("/byid")
    public Optional<TestEntity> guser_byid(@RequestParam(name = "id") Integer userId){
        return testDao.guser_by_id(userId);
    }

    @GetMapping("/byid_attribut")
    public String guser_byid_one_attrbute(@RequestParam(name = "id") Integer userId){
        Optional<TestEntity> user = testDao.guser_by_id(userId);
        if (user.isPresent()){
            return "user name is ===> email : "+user.get().getUsername();
        }else {
            return "user is not exist";
        }
    }

    @GetMapping("/deleteuser")
    public String  user_delete_byid(@RequestParam(name = "id") Integer userId){

        Optional<TestEntity> user = testDao.guser_by_id(userId);
        if (user.isPresent()){
            testDao.user_by_id_delete(userId);
            return "user name is ===> delete";
        }else {
            return "user is not exist";
        }
    }

    @PostMapping("/save_user")
    public TestEntity saveUser(@RequestBody TestEntity user){
        return testDao.save(user);
    }
}