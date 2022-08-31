package com.mmit.beans;

import java.io.Serializable;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.faces.annotation.FacesConfig.Version;

@ApplicationScoped
@FacesConfig(version = Version.JSF_2_3)
public class JSF_Config implements Serializable{

	private static final long serialVersionUID = 1L;

}
