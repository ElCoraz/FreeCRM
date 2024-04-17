package com.crm.free.Components;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;

public class Card extends Component {

    protected String id = "";
    protected String name = "";
    protected String title = "";
    protected String footer = "";

    protected ArrayList<Component> elements = new ArrayList<Component>();

    public Card(String id, String name, String title, String footer) {
        super(id, name);

        this.id = id;
        this.name = name;
        this.title = title;
        this.footer = footer;
    }

    public Card(HashMap<String, String> data) {
        super(data);

        setFields(data);
    }

    public Card(String json) {
        super(json);

        setFields(new JSONObject(json));
    }

    public Card(JSONObject jsonObject) {
        super(jsonObject);

        setFields(jsonObject);
    }

    @Override
    public void add(Component component) {
        elements.add(component);
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
        String content = "";

        for (Component component : elements) {
            content += component.toHTML();
        }

        String template = """
            <card>
                <div class="card" id="{id}" """ +
                            (name.length() == 0 ? "": "name=\"{" + name+ "\"}")
                       + """ 
                    >
                    <div class="card-header">
                        <h3 class="card-title">{title}</h3>
                        <div class="card-tools">
                            <button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
                                <i class="fas fa-minus"></i>
                            </button>
                            <button type="button" class="btn btn-tool" data-card-widget="remove" title="Remove">
                                <i class="fas fa-times"></i>
                            </button>
                        </div>
                    </div>
                    <div class="card-body" style="display: block;">
                    """
                        + content +     
                    """
                     </div>
                    <div class="card-footer" style="display: block;">
                        {footer}
                    </div>
                </div>
            </card>
        """;    

        return replace(template);
    }
 
}
