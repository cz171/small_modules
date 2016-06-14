package eventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class EventListener {
	private  Map<String, ArrayList<Event>> map = new HashMap<>();
	static class Event {
		private Object data;
		public void doEvent(Object data) {
			this.data = data;
		}
	}
	
	public void unregister(String eventName, Event event) {
		if (map.containsKey(eventName)) {
			map.get(eventName).remove(event);
		}
	}
	public void register(String eventName, Event event) {
		if (!map.containsKey(eventName)) {
			map.put(eventName, new ArrayList<>());
		}
		
		map.get(eventName).add(event);
	}
	
	public void postEvent(String eventName, Object data) {
		Event event = new Event();
		event.doEvent(data);
		register(eventName, event);
		
	}
}
