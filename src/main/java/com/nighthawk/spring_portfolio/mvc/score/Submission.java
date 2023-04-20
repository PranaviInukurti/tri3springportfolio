 
package com.nighthawk.spring_portfolio.mvc.score;

import java.util.Map;
import org.hibernate.annotations.TypeDef;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Data;

@Data
@TypeDef(name="json", typeClass = JsonType.class)
public class Submission {
    private String quiz;
    private Map<String,String> sub;
}