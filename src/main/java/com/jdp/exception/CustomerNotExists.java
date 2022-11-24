/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 24-11-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.jdp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Customer with Specific code doesn't exists. Try some other code!")
// A custom exception class which is used to throw an exception when the customer with the specific code doesn't exist.
public class CustomerNotExists extends Exception {
}
