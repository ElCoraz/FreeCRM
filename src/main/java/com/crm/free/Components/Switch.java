package com.crm.free.Components;

import org.json.JSONObject;

public class Switch extends Component {

    protected String id = "";
    protected String name = "";
    protected String label = "";

    public Switch(String id, String name, String label) {
        super(id, name);

        this.id = id;
        this.name = name;
        this.label = label;
    }

    public Switch(String json) {
        super(json);

        setFields(new JSONObject(json));
    }

    public Switch(JSONObject jsonObject) {
        super(jsonObject);

        setFields(jsonObject);
    }

    public String toHTML() throws IllegalArgumentException, IllegalAccessException {
        String template = """
            <div class="form-group">
                <div class="custom-control custom-switch">
                    <input type="checkbox" class="custom-control-input" id="{id}" name="{name}">
                    <label class="custom-control-label" for="{id}">{label}</label>
                </div>
            </div>
        """;    

        return replace(template);
    }
 
}
