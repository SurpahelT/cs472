package com.webapp.jspcustomtag.tags;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDateTimeTag extends SimpleTagSupport {
    private String color;
    private String size;

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        String formattedDate = formatter.format(now);
        out.write(String.format("<span style='color: %s; font-size: %s;'>%s</span>", color, size, formattedDate));
    }
}
