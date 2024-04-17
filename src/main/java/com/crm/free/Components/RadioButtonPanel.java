package com.crm.free.Components;

import org.json.JSONObject;

public class RadioButtonPanel extends Component {

    protected String id = "";
    protected String name = "";
    protected String labels[] = new String[0];

    public RadioButtonPanel(String id, String name, String labels[]) {
        super(id, name);

        this.id = id;
        this.name = name;
        this.labels = labels;
    }

    public RadioButtonPanel(String json) {
        super(json);

        setFields(new JSONObject(json));
    }

    public RadioButtonPanel(JSONObject jsonObject) {
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
        String buttons = "";

        for(int i = 0; i < labels.length; i++) {
            buttons += "<label class='btn btn-secondary'><input type='radio' name='{name}_" + i + "' id='{id}_" + i + "' autocomplete='off' checked=''>" + labels[i] + "</label>";
        }

        String template = """
            <div class="btn-group btn-group-toggle" data-toggle="buttons"> 
            """
                + buttons +
            """
            </div>
        """;    

        return replace(template);
    }
 
}
