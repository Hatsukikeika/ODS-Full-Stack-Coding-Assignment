package fsassignment.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yi
 *
 * A container that generalize the format of HTTP response body.
 */
public class ResponseWrapper {
	private Object data;
	private Map<String, Object> payload = new HashMap<>();
	
	private final String STATS_IDENTIFIER = "status";
	private final String MSG_IDENTIFIER = "message";
	
	public ResponseWrapper() {
		payload.put(STATS_IDENTIFIER, 200);
		payload.put(MSG_IDENTIFIER, "OK");
	}

	public Object getData() {
		return data;
	}

	public Map<String, Object> getPayload() {
		return payload;
	}
	
	public ResponseWrapper putData(Object _data) {
		this.data = _data;
		return this;
	}
	
	public ResponseWrapper setStatus(Integer _code) {
		payload.replace(STATS_IDENTIFIER, _code);
		return this;
	}
	
	public ResponseWrapper setMessage(Object _msg) {
		payload.replace(MSG_IDENTIFIER, _msg);
		return this;
	}
	
	public ResponseWrapper putOption(String _key, Object _val) {
		payload.put(_key, _val);
		return this;
	}
}
