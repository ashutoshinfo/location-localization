package info.ashutosh.domain.json.common;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CustomResponse {

	private int status;

	// In the context of JSON requests and responses, a payload refers to the data
	// being sent or received in the request or response body.
	private Object payload;

	private String message;

	private LocalDateTime requestedAt;

	public CustomResponse(int status, Object payload, String message) {
		this.status = status;
		this.payload = payload;
		this.message = message;
		this.requestedAt = LocalDateTime.now();
	}
}
