package com.santander.autosavings.middleware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santander.autosavings.middleware.model.OperationVO;
import com.santander.autosavings.middleware.model.GoalHistory;
import com.santander.autosavings.middleware.service.GoalTransactionService;
import com.santander.autosavings.middleware.utils.UrlRest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(UrlRest.MONEY)
@Api(value="Transaction Monetary")
public class GoalTransactionController {
	
	@Autowired
	public GoalTransactionService goalTransactionService;
	
	@ApiOperation(value="Post Add money transaction", response=String.class, notes="This operation save in mongodb a new transaction")
	@PostMapping(value=UrlRest.ADD)
	public GoalHistory addMoney(@RequestBody OperationVO operation){
		//TODO montar a chamada para conta corrente
		return goalTransactionService.addMoney(operation);
	}	
	
	@ApiOperation(value="Post WithDraw money transaction", response=String.class, notes="This operation save in mongodb a new transaction")
	@PostMapping(value=UrlRest.WITHDRAW)
	public GoalHistory withDrawMoney(@RequestBody OperationVO operation) {
		return goalTransactionService.withDrawMoney(operation);		
	}	

}
