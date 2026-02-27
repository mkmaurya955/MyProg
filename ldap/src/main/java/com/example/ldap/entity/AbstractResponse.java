package com.example.ldap.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public abstract class AbstractResponse implements Serializable {
	private static final long serialVersionUID = -6332381530908723437L;

	private int status;
	private String message;

}
