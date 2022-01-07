package t1911e.csw.movieService.demo.entity;

import lombok.Data;

@Data
public class BaseRespone {
	private int code;
	private String message;
	private Object data;
}
