/**
 * 
 */
package ar.com.alderian.fatfree.web.bean;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.icesoft.faces.async.render.IntervalRenderer;
import com.icesoft.faces.async.render.RenderManager;
import com.icesoft.faces.async.render.Renderable;
import com.icesoft.faces.webapp.xmlhttp.PersistentFacesState;
import com.icesoft.faces.webapp.xmlhttp.RenderingException;

/**
 * @author oalvarez
 * 
 */
public class TimeBean implements Renderable {
	static int refreshCount = 0;
	int interval = 1000;
	PersistentFacesState state;
	IntervalRenderer clock;

	@Autowired
    RenderManager renderManager;

	public TimeBean() {
		init();
	}

	private void init() {
		state = PersistentFacesState.getInstance();
	}

	public int getRefreshCount() {
		return refreshCount;
	}

	public void setRefreshCount(int refreshCount) {
		TimeBean.refreshCount = refreshCount;
	}

	public Date getNow() {
		return new Date();
	}

	public String refresh() {
		refreshCount++;
		return null;
	}

	@PostConstruct
	public void initClock() {
		clock = renderManager.getIntervalRenderer("clock");
		clock.setInterval(interval);
		clock.add(this);
		clock.requestRender();
	}

	public PersistentFacesState getState() {
		return state;
	}

	public void renderingException(RenderingException renderingException) {
		if (clock != null) {
			clock.remove(this);
			clock = null;
		}
	}

}
