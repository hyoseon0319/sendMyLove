package com.sendmylove.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

public class MyErrorViewResolver implements ErrorViewResolver {

	@Override
	public ModelAndView resolveErrorView(HttpServletRequest request,
			HttpStatus status, Map<String, Object> model) {
      // Use the request or status to optionally return a ModelAndView
      Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
      if (statusCode == 404) {
         return new ModelAndView("/error/404");
      } else if (statusCode == 405) {
         return new ModelAndView("/error/405");
      } else if (statusCode == 500) {
         return new ModelAndView("/error/500");
      }
      return null;
	 }
}