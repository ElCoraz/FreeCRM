package com.crm.free.Components;

import org.json.JSONObject;

public class Loading extends Component {

    protected String id = "";
    protected String name = "";
    protected String text = "";

    public Loading(String id, String name, String text) {
        super(id, name);

        this.id = id;
        this.name = name;
        this.text = text;
    }

    public Loading(String json) {
        super(json);

        setFields(new JSONObject(json));
    }

    public Loading(JSONObject jsonObject) {
        super(jsonObject);

        setFields(jsonObject);
    }

    public String toHTML() throws IllegalArgumentException, IllegalAccessException {
        String template = """
            <div class="overlay-wrapper" id={id} name={name}>
                <div class="overlay">
                    <i class="fas fa-3x fa-sync-alt fa-spin"></i>
                    <div class="text-bold pt-2">
                        {text}...
                    </div>
                </div>
            </div>
        """;    

        return replace(template);
    }
 
}
