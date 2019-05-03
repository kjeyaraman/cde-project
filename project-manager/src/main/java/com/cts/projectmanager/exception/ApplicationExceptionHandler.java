package com.cts.projectmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{


    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<?> recordNotFoundException(RecordNotFoundException ex, WebRequest request) {
		ex.printStackTrace();
        ErrorMsg errorMsg = new ErrorMsg(HttpStatus.NOT_FOUND.value(),ex.getMessage());
        return new ResponseEntity<>(errorMsg, HttpStatus.NOT_FOUND);
    }
	
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalErrorHandler(Exception ex, WebRequest request) {
		ex.printStackTrace();
	     ErrorMsg errorMsg = new ErrorMsg(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Contact System Administrator");
        return new ResponseEntity<>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	

}
