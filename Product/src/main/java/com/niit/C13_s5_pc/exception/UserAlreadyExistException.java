package com.niit.C13_s5_pc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT,reason = "User already Exists")
public class UserAlreadyExistException extends Exception{
}