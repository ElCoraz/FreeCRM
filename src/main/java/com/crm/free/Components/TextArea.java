package com.crm.free.Components;

import org.json.JSONObject;

public class TextArea extends Component {

    protected String id = "";
    protected String name = "";
    protected String text = "";
    protected String placeholder = "";

    protected Integer rows = 1;

    public TextArea(String id, String name, String text, String placeholder, Integer rows) {
        super(id, name);

        this.id = id;
        this.name = name;
        this.text = text;
        this.placeholder = placeholder;

        this.rows = rows;
    }

    public TextArea(String json) {
        super(json);

        setFields(new JSONObject(json));
    }

    public TextArea(JSONObject jsonObject) {
        super(jsonObject);

        setFields(jsonObject);
    }

    @SuppressWarnings("unchecked")
    @Override
    public String atClient() {
        String template = """
            <script>
            </script>
        """;    

        return replace(template);
    }

    @SuppressWarnings("unchecked")
    @Override
    public String toHTML() {
        String template = """
            <div class="form-group">
                <label>Textarea</label>
                <textarea class="form-control" id="{id}" name="{name}" rows="{rows}" placeholder="{placeholder} ...">{text}</textarea>
            </div>
            """;    

        return replace(template);
    }
 
}
