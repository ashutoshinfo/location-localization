package info.ashutosh.util;

import info.ashutosh.domain.json.common.CustomResponse;
import info.ashutosh.enums.ResponseStatus;

public class ResponseUtil {

	public static CustomResponse prepareResponse(ResponseStatus status, Object payload, String message) {
		return new CustomResponse(status.getCode(), payload, status.getMessage() + " : " + message);
	}
}