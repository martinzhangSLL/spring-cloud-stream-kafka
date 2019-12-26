package com.rgs.template.controller.Section1;

import com.rgs.core.exception.ServiceException;
import com.rgs.core.interaction.ServiceApiResult;
import com.rgs.core.stream.header.HeaderSource;
import com.rgs.template.serviceimpl.stream.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags="Produce Message", value="Producer")
@RequestMapping("section1")
public class Item1Controller {

    @Autowired
    CommonSendService commonSendService;

    @Autowired
    GroupSendService groupSendService;

    @Autowired
    TransSendService transSendService;

    @Autowired
    PartitionSendService partitionSendService;

    @Autowired
    HeaderSendService headerSendService;


    @GetMapping("/SimpleProduce")
    @ApiOperation(value = "SimpleProduce")
    public ServiceApiResult SimpleProduce(){

        ServiceApiResult result;
        try{

            commonSendService.SendMsg("Hello world");
            result=ServiceApiResult.ok(true);

        }
        catch(ServiceException ex){
            result=ServiceApiResult.error(ex.getMsg());
        }
        catch(Exception ex){
            result=ServiceApiResult.error(ex.getMessage());
        }
        return result;
    }

    @GetMapping("/GroupProduce")
    @ApiOperation(value = "GroupProduce")
    public ServiceApiResult GroupProduce(){

        ServiceApiResult result;
        try{

            groupSendService.sendMsg("Hello world in group");
            result=ServiceApiResult.ok(true);

        }
        catch(ServiceException ex){
            result=ServiceApiResult.error(ex.getMsg());
        }
        catch(Exception ex){
            result=ServiceApiResult.error(ex.getMessage());
        }
        return result;
    }

    @GetMapping("/TransProduce")
    @ApiOperation(value = "TransProduce")
    public ServiceApiResult TransProduce(){

        ServiceApiResult result;
        try{

            transSendService.sendMsg("Hello world in Trans");
            result=ServiceApiResult.ok(true);

        }
        catch(ServiceException ex){
            result=ServiceApiResult.error(ex.getMsg());
        }
        catch(Exception ex){
            result=ServiceApiResult.error(ex.getMessage());
        }
        return result;
    }

    @GetMapping("/PartitionProduce")
    @ApiOperation(value = "PartitionProduce")
    public ServiceApiResult PartitionProduce(){

        ServiceApiResult result;
        try{

            partitionSendService.sendMsg("Hello world in partition");
            result=ServiceApiResult.ok(true);

        }
        catch(ServiceException ex){
            result=ServiceApiResult.error(ex.getMsg());
        }
        catch(Exception ex){
            result=ServiceApiResult.error(ex.getMessage());
        }
        return result;
    }

    @GetMapping("/HeaderProduce")
    @ApiOperation(value = "HeaderProduce")
    public ServiceApiResult HeaderProduce(@RequestParam(value="msg") String msg, @RequestParam(value="type") String type ){

        ServiceApiResult result;
        try{

            headerSendService.sendMsg(msg,type);
            result=ServiceApiResult.ok(true);

        }
        catch(ServiceException ex){
            result=ServiceApiResult.error(ex.getMsg());
        }
        catch(Exception ex){
            result=ServiceApiResult.error(ex.getMessage());
        }
        return result;
    }
}
