package com.mycompany;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));

	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);

		// demo.css is compiled at build time by gulp-less plugin
		response.render(CssHeaderItem.forReference(new CssResourceReference(HomePage.class, "res/demo.css")));

		// demo.js is JSHint-ed and Uglify-ed at build time
		// in DEPLOYMENT mode Wicket will load demo.min.js
		response.render(JavaScriptHeaderItem.forReference(new JavaScriptResourceReference(HomePage.class, "res/demo.js")));
	}
}
