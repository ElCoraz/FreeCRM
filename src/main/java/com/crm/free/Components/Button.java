package com.crm.free.Components;

import org.json.JSONObject;

public class Button extends Component {

    protected String id = "";
    protected String name = "";
    protected String text = "";

    public Button(String id, String name, String text) {
        super(id, name);

        this.id = id;
        this.name = name;
        this.text = text;
    }

    public Button(String json) {
        super(json);

        setFields(new JSONObject(json));
    }

    public Button(JSONObject jsonObject) {
        super(jsonObject);

        setFields(jsonObject);
    }

    public String toHTML() throws IllegalArgumentException, IllegalAccessException {
        String template = """
                <button type="button" class="btn btn-block btn-primary" id="{id}" name="{name}">{text}</button>
            """;    

        return replace(template);
    }
 
}
