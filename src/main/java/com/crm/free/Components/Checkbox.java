package com.crm.free.Components;

import org.json.JSONObject;

public class Checkbox extends Component {

    protected String id = "";
    protected String name = "";
    protected String label = "";
    protected String value = "";

    public Checkbox(String id, String name, String label, String value) {
        super(id, name);

        this.id = id;
        this.name = name;
        this.label = label;
        this.value = value;
    }

    public Checkbox(String json) {
        super(json);

        setFields(new JSONObject(json));
    }

    public Checkbox(JSONObject jsonObject) {
        super(jsonObject);

        setFields(jsonObject);
    }

    @Override
    public String toHTML() throws IllegalArgumentException, IllegalAccessException {
        String template = """
            <div class="custom-control custom-checkbox">
                <input class="custom-control-input" type="checkbox" id="{id}" name="{name}" value="{value}">
                <label for="{id}" class="custom-control-label">{label}</label>
            </div>
            """;    

        return replace(template);
    }
 
}
