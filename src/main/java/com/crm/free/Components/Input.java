package com.crm.free.Components;

import org.json.JSONObject;

public class Input extends Component {

    protected String id = "";
    protected String name = "";
    protected String value = "";
    protected String placeholder = "";

    public Input(String id, String name, String value, String placeholder) {
        super(id, name);

        this.id = id;
        this.name = name;
        this.value = value;
        this.placeholder = placeholder;
    }

    public Input(String json) {
        super(json);

        setFields(new JSONObject(json));
    }

    public Input(JSONObject jsonObject) {
        super(jsonObject);

        setFields(jsonObject);
    }

    @Override
    public String toHTML() throws IllegalArgumentException, IllegalAccessException {
        String template = """
                <input class="form-control form-control-lg" type="text" id="{id}" name="{name}" value="{value}" placeholder="{placeholder}">
            """;    

        return replace(template);
    }
 
}
