
package com.ametis.cms.web.validator;

import com.ametis.cms.datamodel.*;
import com.ametis.cms.web.form.*;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
// imports+ 

// imports- 

/**
 * ProviderGroup is a mapping of provider_group Table.
*/
public class ProviderGroupValidator implements Validator
// extends+ 

// extends- 
{
	public boolean supports(Class clazz) {
		return ProviderGroupForm.class.isAssignableFrom(clazz);
	}
	public void validate(Object obj, Errors errors) {
								ValidationUtils.rejectIfEmptyOrWhitespace
 (errors,"providerGroupId","PROVIDER_GROUP_ID_REQUIRED","providerGroupId is required");
																																																																																																																														
// foreign affairs
		// -- foreign affairs end

	}

// class+ 

// class- 
}
