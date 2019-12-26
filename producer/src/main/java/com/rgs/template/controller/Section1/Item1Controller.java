package com.rgs.template.controller.Section1;

import com.rgs.core.exception.ServiceException;
import com.rgs.core.interaction.ServiceApiResult;
import com.rgs.template.serviceimpl.stream.CommonSendService;
import com.rgs.template.serviceimpl.stream.GroupSendService;
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
}
