package org.techcir.querybuilder.util.types;

import org.techcir.querybuilder.util.CQueryConstant;
import org.techcir.querybuilder.util.CQueryUtil;

/**
 * @auther : chamly
 * @date : 3/4/15
 * @time : 10:09 PM
 * CQueryCondition : Query Condition Mapping Class.
 */
public enum  CQueryCondition {
    /**
     * Ex : firstName = :firstName
     */
    EQUAL() {
        @Override
        public String getParamCondition(String paramName) {
            setParameter(paramName);
            return CQueryConstant.QueryConstant.EQUAL + paramName;
        }
    },
    /**
     * Ex: firstName like '%' || :firstName || '%'
     */
    WRAP_LIKE() {
        @Override
        public String getParamCondition(String paramName) {
            setParameter(paramName);
            return CQueryConstant.QueryConstant.LIKE + CQueryUtil.getLikeConcatString(true) +paramName +
                    CQueryUtil.getLikeConcatString(false);
        }
    },
    /**
     * Ex : firstName like '%' || :firstName
     */
    PREFIX_LIKE() {
        @Override
        public String getParamCondition(String paramName) {
            setParameter(paramName);
            return CQueryConstant.QueryConstant.LIKE + CQueryUtil.getLikeConcatString(true) + paramName;
        }
    },
    /**
     * Ex : firstName like :firstName || '%'
     */
    POSTFIX_LIKE() {
        @Override
        public String getParamCondition(String paramName) {
            setParameter(paramName);
            return CQueryConstant.QueryConstant.LIKE + paramName + CQueryUtil.getLikeConcatString(false);
        }
    },
    /**
     * Ex : age > :age
     */
    GREATER_THAN() {
        @Override
        public String getParamCondition(String paramName) {
            setParameter(paramName);
            return CQueryConstant.QueryConstant.GT + paramName;
        }
    },
    /**
     * Ex : age < :age
     */
    LESS_THAN() {
        @Override
        public String getParamCondition(String paramName) {
            setParameter(paramName);
            return CQueryConstant.QueryConstant.LT + paramName;
        }
    };

    private String parameter;

    public abstract String getParamCondition(String paramName);
    public  String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
}
