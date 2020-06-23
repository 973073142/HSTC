package com.pro.entity;

import java.util.ArrayList;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUaccountIsNull() {
            addCriterion("uaccount is null");
            return (Criteria) this;
        }

        public Criteria andUaccountIsNotNull() {
            addCriterion("uaccount is not null");
            return (Criteria) this;
        }

        public Criteria andUaccountEqualTo(String value) {
            addCriterion("uaccount =", value, "uaccount");
            return (Criteria) this;
        }

        public Criteria andUaccountNotEqualTo(String value) {
            addCriterion("uaccount <>", value, "uaccount");
            return (Criteria) this;
        }

        public Criteria andUaccountGreaterThan(String value) {
            addCriterion("uaccount >", value, "uaccount");
            return (Criteria) this;
        }

        public Criteria andUaccountGreaterThanOrEqualTo(String value) {
            addCriterion("uaccount >=", value, "uaccount");
            return (Criteria) this;
        }

        public Criteria andUaccountLessThan(String value) {
            addCriterion("uaccount <", value, "uaccount");
            return (Criteria) this;
        }

        public Criteria andUaccountLessThanOrEqualTo(String value) {
            addCriterion("uaccount <=", value, "uaccount");
            return (Criteria) this;
        }

        public Criteria andUaccountLike(String value) {
            addCriterion("uaccount like", value, "uaccount");
            return (Criteria) this;
        }

        public Criteria andUaccountNotLike(String value) {
            addCriterion("uaccount not like", value, "uaccount");
            return (Criteria) this;
        }

        public Criteria andUaccountIn(List<String> values) {
            addCriterion("uaccount in", values, "uaccount");
            return (Criteria) this;
        }

        public Criteria andUaccountNotIn(List<String> values) {
            addCriterion("uaccount not in", values, "uaccount");
            return (Criteria) this;
        }

        public Criteria andUaccountBetween(String value1, String value2) {
            addCriterion("uaccount between", value1, value2, "uaccount");
            return (Criteria) this;
        }

        public Criteria andUaccountNotBetween(String value1, String value2) {
            addCriterion("uaccount not between", value1, value2, "uaccount");
            return (Criteria) this;
        }

        public Criteria andUpswIsNull() {
            addCriterion("upsw is null");
            return (Criteria) this;
        }

        public Criteria andUpswIsNotNull() {
            addCriterion("upsw is not null");
            return (Criteria) this;
        }

        public Criteria andUpswEqualTo(String value) {
            addCriterion("upsw =", value, "upsw");
            return (Criteria) this;
        }

        public Criteria andUpswNotEqualTo(String value) {
            addCriterion("upsw <>", value, "upsw");
            return (Criteria) this;
        }

        public Criteria andUpswGreaterThan(String value) {
            addCriterion("upsw >", value, "upsw");
            return (Criteria) this;
        }

        public Criteria andUpswGreaterThanOrEqualTo(String value) {
            addCriterion("upsw >=", value, "upsw");
            return (Criteria) this;
        }

        public Criteria andUpswLessThan(String value) {
            addCriterion("upsw <", value, "upsw");
            return (Criteria) this;
        }

        public Criteria andUpswLessThanOrEqualTo(String value) {
            addCriterion("upsw <=", value, "upsw");
            return (Criteria) this;
        }

        public Criteria andUpswLike(String value) {
            addCriterion("upsw like", value, "upsw");
            return (Criteria) this;
        }

        public Criteria andUpswNotLike(String value) {
            addCriterion("upsw not like", value, "upsw");
            return (Criteria) this;
        }

        public Criteria andUpswIn(List<String> values) {
            addCriterion("upsw in", values, "upsw");
            return (Criteria) this;
        }

        public Criteria andUpswNotIn(List<String> values) {
            addCriterion("upsw not in", values, "upsw");
            return (Criteria) this;
        }

        public Criteria andUpswBetween(String value1, String value2) {
            addCriterion("upsw between", value1, value2, "upsw");
            return (Criteria) this;
        }

        public Criteria andUpswNotBetween(String value1, String value2) {
            addCriterion("upsw not between", value1, value2, "upsw");
            return (Criteria) this;
        }

        public Criteria andUnameIsNull() {
            addCriterion("uname is null");
            return (Criteria) this;
        }

        public Criteria andUnameIsNotNull() {
            addCriterion("uname is not null");
            return (Criteria) this;
        }

        public Criteria andUnameEqualTo(String value) {
            addCriterion("uname =", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotEqualTo(String value) {
            addCriterion("uname <>", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThan(String value) {
            addCriterion("uname >", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThanOrEqualTo(String value) {
            addCriterion("uname >=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThan(String value) {
            addCriterion("uname <", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThanOrEqualTo(String value) {
            addCriterion("uname <=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLike(String value) {
            addCriterion("uname like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotLike(String value) {
            addCriterion("uname not like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameIn(List<String> values) {
            addCriterion("uname in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotIn(List<String> values) {
            addCriterion("uname not in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameBetween(String value1, String value2) {
            addCriterion("uname between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotBetween(String value1, String value2) {
            addCriterion("uname not between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andUiconIsNull() {
            addCriterion("uicon is null");
            return (Criteria) this;
        }

        public Criteria andUiconIsNotNull() {
            addCriterion("uicon is not null");
            return (Criteria) this;
        }

        public Criteria andUiconEqualTo(String value) {
            addCriterion("uicon =", value, "uicon");
            return (Criteria) this;
        }

        public Criteria andUiconNotEqualTo(String value) {
            addCriterion("uicon <>", value, "uicon");
            return (Criteria) this;
        }

        public Criteria andUiconGreaterThan(String value) {
            addCriterion("uicon >", value, "uicon");
            return (Criteria) this;
        }

        public Criteria andUiconGreaterThanOrEqualTo(String value) {
            addCriterion("uicon >=", value, "uicon");
            return (Criteria) this;
        }

        public Criteria andUiconLessThan(String value) {
            addCriterion("uicon <", value, "uicon");
            return (Criteria) this;
        }

        public Criteria andUiconLessThanOrEqualTo(String value) {
            addCriterion("uicon <=", value, "uicon");
            return (Criteria) this;
        }

        public Criteria andUiconLike(String value) {
            addCriterion("uicon like", value, "uicon");
            return (Criteria) this;
        }

        public Criteria andUiconNotLike(String value) {
            addCriterion("uicon not like", value, "uicon");
            return (Criteria) this;
        }

        public Criteria andUiconIn(List<String> values) {
            addCriterion("uicon in", values, "uicon");
            return (Criteria) this;
        }

        public Criteria andUiconNotIn(List<String> values) {
            addCriterion("uicon not in", values, "uicon");
            return (Criteria) this;
        }

        public Criteria andUiconBetween(String value1, String value2) {
            addCriterion("uicon between", value1, value2, "uicon");
            return (Criteria) this;
        }

        public Criteria andUiconNotBetween(String value1, String value2) {
            addCriterion("uicon not between", value1, value2, "uicon");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}