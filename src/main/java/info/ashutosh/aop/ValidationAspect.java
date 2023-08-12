package info.ashutosh.aop;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import info.ashutosh.domain.json.common.CustomResponse;
import info.ashutosh.enums.ResponseStatus;
import info.ashutosh.util.ResponseUtil;

@Aspect
@Component
public class ValidationAspect {

	// @Around("@annotation(info.ashutosh.aop.CheckValidation) &&
	// args(info.ashutosh.entity.CookRequest,bindingResult)")
	@Around("@annotation(info.ashutosh.aop.CheckValidation)")
	public Object handleValidationErrors(ProceedingJoinPoint joinPoint) throws Throwable {
		// Get the arguments of the target method
		Object[] args = joinPoint.getArgs();

		// Find the BindingResult argument, if present
		BindingResult bindingResult = findBindingResult(args);

		// Perform the validation check
		if (bindingResult != null && bindingResult.hasErrors()) {
			List<String> errorMessages = new ArrayList<>();
			for (FieldError error : bindingResult.getFieldErrors()) {
				String errorMessage = error.getField() + ": " + error.getDefaultMessage();
				errorMessages.add(errorMessage);
			}

			CustomResponse response = ResponseUtil.prepareResponse(ResponseStatus.BAD_CREDENTIAL, null,
					errorMessages.toString());

			// return the response or handle it as needed
			return response;
		}

		// Proceed with the execution of the target method
		return joinPoint.proceed();
	}

	// Helper method to find the BindingResult argument in the method arguments
	private BindingResult findBindingResult(Object[] args) {
		for (Object arg : args) {
			if (arg instanceof BindingResult) {
				return (BindingResult) arg;
			}
		}
		return null;
	}

}