package br.com.takeshi.spring_boot_rest.exception;

import java.util.Date;

//formatar a exception de forma amigavel
public record ExceptionResponse(Date timestamp, String message, String details) {}
