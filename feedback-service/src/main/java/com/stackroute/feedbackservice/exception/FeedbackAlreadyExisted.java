package com.stackroute.feedbackservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "feedback already found")
public class FeedbackAlreadyExisted extends Exception{
}
