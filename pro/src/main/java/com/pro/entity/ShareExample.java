package com.pro.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShareExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShareExample() {
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

        public Criteria andSidIsNull() {
            addCriterion("sid is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("sid is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(Integer value) {
            addCriterion("sid =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(Integer value) {
            addCriterion("sid <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(Integer value) {
            addCriterion("sid >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sid >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(Integer value) {
            addCriterion("sid <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(Integer value) {
            addCriterion("sid <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<Integer> values) {
            addCriterion("sid in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<Integer> values) {
            addCriterion("sid not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(Integer value1, Integer value2) {
            addCriterion("sid between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(Integer value1, Integer value2) {
            addCriterion("sid not between", value1, value2, "sid");
            return (Criteria) this;
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

        public Criteria andStitleIsNull() {
            addCriterion("stitle is null");
            return (Criteria) this;
        }

        public Criteria andStitleIsNotNull() {
            addCriterion("stitle is not null");
            return (Criteria) this;
        }

        public Criteria andStitleEqualTo(String value) {
            addCriterion("stitle =", value, "stitle");
            return (Criteria) this;
        }

        public Criteria andStitleNotEqualTo(String value) {
            addCriterion("stitle <>", value, "stitle");
            return (Criteria) this;
        }

        public Criteria andStitleGreaterThan(String value) {
            addCriterion("stitle >", value, "stitle");
            return (Criteria) this;
        }

        public Criteria andStitleGreaterThanOrEqualTo(String value) {
            addCriterion("stitle >=", value, "stitle");
            return (Criteria) this;
        }

        public Criteria andStitleLessThan(String value) {
            addCriterion("stitle <", value, "stitle");
            return (Criteria) this;
        }

        public Criteria andStitleLessThanOrEqualTo(String value) {
            addCriterion("stitle <=", value, "stitle");
            return (Criteria) this;
        }

        public Criteria andStitleLike(String value) {
            addCriterion("stitle like", value, "stitle");
            return (Criteria) this;
        }

        public Criteria andStitleNotLike(String value) {
            addCriterion("stitle not like", value, "stitle");
            return (Criteria) this;
        }

        public Criteria andStitleIn(List<String> values) {
            addCriterion("stitle in", values, "stitle");
            return (Criteria) this;
        }

        public Criteria andStitleNotIn(List<String> values) {
            addCriterion("stitle not in", values, "stitle");
            return (Criteria) this;
        }

        public Criteria andStitleBetween(String value1, String value2) {
            addCriterion("stitle between", value1, value2, "stitle");
            return (Criteria) this;
        }

        public Criteria andStitleNotBetween(String value1, String value2) {
            addCriterion("stitle not between", value1, value2, "stitle");
            return (Criteria) this;
        }

        public Criteria andScontentIsNull() {
            addCriterion("scontent is null");
            return (Criteria) this;
        }

        public Criteria andScontentIsNotNull() {
            addCriterion("scontent is not null");
            return (Criteria) this;
        }

        public Criteria andScontentEqualTo(String value) {
            addCriterion("scontent =", value, "scontent");
            return (Criteria) this;
        }

        public Criteria andScontentNotEqualTo(String value) {
            addCriterion("scontent <>", value, "scontent");
            return (Criteria) this;
        }

        public Criteria andScontentGreaterThan(String value) {
            addCriterion("scontent >", value, "scontent");
            return (Criteria) this;
        }

        public Criteria andScontentGreaterThanOrEqualTo(String value) {
            addCriterion("scontent >=", value, "scontent");
            return (Criteria) this;
        }

        public Criteria andScontentLessThan(String value) {
            addCriterion("scontent <", value, "scontent");
            return (Criteria) this;
        }

        public Criteria andScontentLessThanOrEqualTo(String value) {
            addCriterion("scontent <=", value, "scontent");
            return (Criteria) this;
        }

        public Criteria andScontentLike(String value) {
            addCriterion("scontent like", value, "scontent");
            return (Criteria) this;
        }

        public Criteria andScontentNotLike(String value) {
            addCriterion("scontent not like", value, "scontent");
            return (Criteria) this;
        }

        public Criteria andScontentIn(List<String> values) {
            addCriterion("scontent in", values, "scontent");
            return (Criteria) this;
        }

        public Criteria andScontentNotIn(List<String> values) {
            addCriterion("scontent not in", values, "scontent");
            return (Criteria) this;
        }

        public Criteria andScontentBetween(String value1, String value2) {
            addCriterion("scontent between", value1, value2, "scontent");
            return (Criteria) this;
        }

        public Criteria andScontentNotBetween(String value1, String value2) {
            addCriterion("scontent not between", value1, value2, "scontent");
            return (Criteria) this;
        }

        public Criteria andSimg1IsNull() {
            addCriterion("simg1 is null");
            return (Criteria) this;
        }

        public Criteria andSimg1IsNotNull() {
            addCriterion("simg1 is not null");
            return (Criteria) this;
        }

        public Criteria andSimg1EqualTo(String value) {
            addCriterion("simg1 =", value, "simg1");
            return (Criteria) this;
        }

        public Criteria andSimg1NotEqualTo(String value) {
            addCriterion("simg1 <>", value, "simg1");
            return (Criteria) this;
        }

        public Criteria andSimg1GreaterThan(String value) {
            addCriterion("simg1 >", value, "simg1");
            return (Criteria) this;
        }

        public Criteria andSimg1GreaterThanOrEqualTo(String value) {
            addCriterion("simg1 >=", value, "simg1");
            return (Criteria) this;
        }

        public Criteria andSimg1LessThan(String value) {
            addCriterion("simg1 <", value, "simg1");
            return (Criteria) this;
        }

        public Criteria andSimg1LessThanOrEqualTo(String value) {
            addCriterion("simg1 <=", value, "simg1");
            return (Criteria) this;
        }

        public Criteria andSimg1Like(String value) {
            addCriterion("simg1 like", value, "simg1");
            return (Criteria) this;
        }

        public Criteria andSimg1NotLike(String value) {
            addCriterion("simg1 not like", value, "simg1");
            return (Criteria) this;
        }

        public Criteria andSimg1In(List<String> values) {
            addCriterion("simg1 in", values, "simg1");
            return (Criteria) this;
        }

        public Criteria andSimg1NotIn(List<String> values) {
            addCriterion("simg1 not in", values, "simg1");
            return (Criteria) this;
        }

        public Criteria andSimg1Between(String value1, String value2) {
            addCriterion("simg1 between", value1, value2, "simg1");
            return (Criteria) this;
        }

        public Criteria andSimg1NotBetween(String value1, String value2) {
            addCriterion("simg1 not between", value1, value2, "simg1");
            return (Criteria) this;
        }

        public Criteria andSimg2IsNull() {
            addCriterion("simg2 is null");
            return (Criteria) this;
        }

        public Criteria andSimg2IsNotNull() {
            addCriterion("simg2 is not null");
            return (Criteria) this;
        }

        public Criteria andSimg2EqualTo(String value) {
            addCriterion("simg2 =", value, "simg2");
            return (Criteria) this;
        }

        public Criteria andSimg2NotEqualTo(String value) {
            addCriterion("simg2 <>", value, "simg2");
            return (Criteria) this;
        }

        public Criteria andSimg2GreaterThan(String value) {
            addCriterion("simg2 >", value, "simg2");
            return (Criteria) this;
        }

        public Criteria andSimg2GreaterThanOrEqualTo(String value) {
            addCriterion("simg2 >=", value, "simg2");
            return (Criteria) this;
        }

        public Criteria andSimg2LessThan(String value) {
            addCriterion("simg2 <", value, "simg2");
            return (Criteria) this;
        }

        public Criteria andSimg2LessThanOrEqualTo(String value) {
            addCriterion("simg2 <=", value, "simg2");
            return (Criteria) this;
        }

        public Criteria andSimg2Like(String value) {
            addCriterion("simg2 like", value, "simg2");
            return (Criteria) this;
        }

        public Criteria andSimg2NotLike(String value) {
            addCriterion("simg2 not like", value, "simg2");
            return (Criteria) this;
        }

        public Criteria andSimg2In(List<String> values) {
            addCriterion("simg2 in", values, "simg2");
            return (Criteria) this;
        }

        public Criteria andSimg2NotIn(List<String> values) {
            addCriterion("simg2 not in", values, "simg2");
            return (Criteria) this;
        }

        public Criteria andSimg2Between(String value1, String value2) {
            addCriterion("simg2 between", value1, value2, "simg2");
            return (Criteria) this;
        }

        public Criteria andSimg2NotBetween(String value1, String value2) {
            addCriterion("simg2 not between", value1, value2, "simg2");
            return (Criteria) this;
        }

        public Criteria andSimg3IsNull() {
            addCriterion("simg3 is null");
            return (Criteria) this;
        }

        public Criteria andSimg3IsNotNull() {
            addCriterion("simg3 is not null");
            return (Criteria) this;
        }

        public Criteria andSimg3EqualTo(String value) {
            addCriterion("simg3 =", value, "simg3");
            return (Criteria) this;
        }

        public Criteria andSimg3NotEqualTo(String value) {
            addCriterion("simg3 <>", value, "simg3");
            return (Criteria) this;
        }

        public Criteria andSimg3GreaterThan(String value) {
            addCriterion("simg3 >", value, "simg3");
            return (Criteria) this;
        }

        public Criteria andSimg3GreaterThanOrEqualTo(String value) {
            addCriterion("simg3 >=", value, "simg3");
            return (Criteria) this;
        }

        public Criteria andSimg3LessThan(String value) {
            addCriterion("simg3 <", value, "simg3");
            return (Criteria) this;
        }

        public Criteria andSimg3LessThanOrEqualTo(String value) {
            addCriterion("simg3 <=", value, "simg3");
            return (Criteria) this;
        }

        public Criteria andSimg3Like(String value) {
            addCriterion("simg3 like", value, "simg3");
            return (Criteria) this;
        }

        public Criteria andSimg3NotLike(String value) {
            addCriterion("simg3 not like", value, "simg3");
            return (Criteria) this;
        }

        public Criteria andSimg3In(List<String> values) {
            addCriterion("simg3 in", values, "simg3");
            return (Criteria) this;
        }

        public Criteria andSimg3NotIn(List<String> values) {
            addCriterion("simg3 not in", values, "simg3");
            return (Criteria) this;
        }

        public Criteria andSimg3Between(String value1, String value2) {
            addCriterion("simg3 between", value1, value2, "simg3");
            return (Criteria) this;
        }

        public Criteria andSimg3NotBetween(String value1, String value2) {
            addCriterion("simg3 not between", value1, value2, "simg3");
            return (Criteria) this;
        }

        public Criteria andSimg4IsNull() {
            addCriterion("simg4 is null");
            return (Criteria) this;
        }

        public Criteria andSimg4IsNotNull() {
            addCriterion("simg4 is not null");
            return (Criteria) this;
        }

        public Criteria andSimg4EqualTo(String value) {
            addCriterion("simg4 =", value, "simg4");
            return (Criteria) this;
        }

        public Criteria andSimg4NotEqualTo(String value) {
            addCriterion("simg4 <>", value, "simg4");
            return (Criteria) this;
        }

        public Criteria andSimg4GreaterThan(String value) {
            addCriterion("simg4 >", value, "simg4");
            return (Criteria) this;
        }

        public Criteria andSimg4GreaterThanOrEqualTo(String value) {
            addCriterion("simg4 >=", value, "simg4");
            return (Criteria) this;
        }

        public Criteria andSimg4LessThan(String value) {
            addCriterion("simg4 <", value, "simg4");
            return (Criteria) this;
        }

        public Criteria andSimg4LessThanOrEqualTo(String value) {
            addCriterion("simg4 <=", value, "simg4");
            return (Criteria) this;
        }

        public Criteria andSimg4Like(String value) {
            addCriterion("simg4 like", value, "simg4");
            return (Criteria) this;
        }

        public Criteria andSimg4NotLike(String value) {
            addCriterion("simg4 not like", value, "simg4");
            return (Criteria) this;
        }

        public Criteria andSimg4In(List<String> values) {
            addCriterion("simg4 in", values, "simg4");
            return (Criteria) this;
        }

        public Criteria andSimg4NotIn(List<String> values) {
            addCriterion("simg4 not in", values, "simg4");
            return (Criteria) this;
        }

        public Criteria andSimg4Between(String value1, String value2) {
            addCriterion("simg4 between", value1, value2, "simg4");
            return (Criteria) this;
        }

        public Criteria andSimg4NotBetween(String value1, String value2) {
            addCriterion("simg4 not between", value1, value2, "simg4");
            return (Criteria) this;
        }

        public Criteria andSimg5IsNull() {
            addCriterion("simg5 is null");
            return (Criteria) this;
        }

        public Criteria andSimg5IsNotNull() {
            addCriterion("simg5 is not null");
            return (Criteria) this;
        }

        public Criteria andSimg5EqualTo(String value) {
            addCriterion("simg5 =", value, "simg5");
            return (Criteria) this;
        }

        public Criteria andSimg5NotEqualTo(String value) {
            addCriterion("simg5 <>", value, "simg5");
            return (Criteria) this;
        }

        public Criteria andSimg5GreaterThan(String value) {
            addCriterion("simg5 >", value, "simg5");
            return (Criteria) this;
        }

        public Criteria andSimg5GreaterThanOrEqualTo(String value) {
            addCriterion("simg5 >=", value, "simg5");
            return (Criteria) this;
        }

        public Criteria andSimg5LessThan(String value) {
            addCriterion("simg5 <", value, "simg5");
            return (Criteria) this;
        }

        public Criteria andSimg5LessThanOrEqualTo(String value) {
            addCriterion("simg5 <=", value, "simg5");
            return (Criteria) this;
        }

        public Criteria andSimg5Like(String value) {
            addCriterion("simg5 like", value, "simg5");
            return (Criteria) this;
        }

        public Criteria andSimg5NotLike(String value) {
            addCriterion("simg5 not like", value, "simg5");
            return (Criteria) this;
        }

        public Criteria andSimg5In(List<String> values) {
            addCriterion("simg5 in", values, "simg5");
            return (Criteria) this;
        }

        public Criteria andSimg5NotIn(List<String> values) {
            addCriterion("simg5 not in", values, "simg5");
            return (Criteria) this;
        }

        public Criteria andSimg5Between(String value1, String value2) {
            addCriterion("simg5 between", value1, value2, "simg5");
            return (Criteria) this;
        }

        public Criteria andSimg5NotBetween(String value1, String value2) {
            addCriterion("simg5 not between", value1, value2, "simg5");
            return (Criteria) this;
        }

        public Criteria andSimg6IsNull() {
            addCriterion("simg6 is null");
            return (Criteria) this;
        }

        public Criteria andSimg6IsNotNull() {
            addCriterion("simg6 is not null");
            return (Criteria) this;
        }

        public Criteria andSimg6EqualTo(String value) {
            addCriterion("simg6 =", value, "simg6");
            return (Criteria) this;
        }

        public Criteria andSimg6NotEqualTo(String value) {
            addCriterion("simg6 <>", value, "simg6");
            return (Criteria) this;
        }

        public Criteria andSimg6GreaterThan(String value) {
            addCriterion("simg6 >", value, "simg6");
            return (Criteria) this;
        }

        public Criteria andSimg6GreaterThanOrEqualTo(String value) {
            addCriterion("simg6 >=", value, "simg6");
            return (Criteria) this;
        }

        public Criteria andSimg6LessThan(String value) {
            addCriterion("simg6 <", value, "simg6");
            return (Criteria) this;
        }

        public Criteria andSimg6LessThanOrEqualTo(String value) {
            addCriterion("simg6 <=", value, "simg6");
            return (Criteria) this;
        }

        public Criteria andSimg6Like(String value) {
            addCriterion("simg6 like", value, "simg6");
            return (Criteria) this;
        }

        public Criteria andSimg6NotLike(String value) {
            addCriterion("simg6 not like", value, "simg6");
            return (Criteria) this;
        }

        public Criteria andSimg6In(List<String> values) {
            addCriterion("simg6 in", values, "simg6");
            return (Criteria) this;
        }

        public Criteria andSimg6NotIn(List<String> values) {
            addCriterion("simg6 not in", values, "simg6");
            return (Criteria) this;
        }

        public Criteria andSimg6Between(String value1, String value2) {
            addCriterion("simg6 between", value1, value2, "simg6");
            return (Criteria) this;
        }

        public Criteria andSimg6NotBetween(String value1, String value2) {
            addCriterion("simg6 not between", value1, value2, "simg6");
            return (Criteria) this;
        }

        public Criteria andSdateIsNull() {
            addCriterion("sdate is null");
            return (Criteria) this;
        }

        public Criteria andSdateIsNotNull() {
            addCriterion("sdate is not null");
            return (Criteria) this;
        }

        public Criteria andSdateEqualTo(Date value) {
            addCriterion("sdate =", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateNotEqualTo(Date value) {
            addCriterion("sdate <>", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateGreaterThan(Date value) {
            addCriterion("sdate >", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateGreaterThanOrEqualTo(Date value) {
            addCriterion("sdate >=", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateLessThan(Date value) {
            addCriterion("sdate <", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateLessThanOrEqualTo(Date value) {
            addCriterion("sdate <=", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateIn(List<Date> values) {
            addCriterion("sdate in", values, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateNotIn(List<Date> values) {
            addCriterion("sdate not in", values, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateBetween(Date value1, Date value2) {
            addCriterion("sdate between", value1, value2, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateNotBetween(Date value1, Date value2) {
            addCriterion("sdate not between", value1, value2, "sdate");
            return (Criteria) this;
        }

        public Criteria andSlikeIsNull() {
            addCriterion("slike is null");
            return (Criteria) this;
        }

        public Criteria andSlikeIsNotNull() {
            addCriterion("slike is not null");
            return (Criteria) this;
        }

        public Criteria andSlikeEqualTo(Integer value) {
            addCriterion("slike =", value, "slike");
            return (Criteria) this;
        }

        public Criteria andSlikeNotEqualTo(Integer value) {
            addCriterion("slike <>", value, "slike");
            return (Criteria) this;
        }

        public Criteria andSlikeGreaterThan(Integer value) {
            addCriterion("slike >", value, "slike");
            return (Criteria) this;
        }

        public Criteria andSlikeGreaterThanOrEqualTo(Integer value) {
            addCriterion("slike >=", value, "slike");
            return (Criteria) this;
        }

        public Criteria andSlikeLessThan(Integer value) {
            addCriterion("slike <", value, "slike");
            return (Criteria) this;
        }

        public Criteria andSlikeLessThanOrEqualTo(Integer value) {
            addCriterion("slike <=", value, "slike");
            return (Criteria) this;
        }

        public Criteria andSlikeIn(List<Integer> values) {
            addCriterion("slike in", values, "slike");
            return (Criteria) this;
        }

        public Criteria andSlikeNotIn(List<Integer> values) {
            addCriterion("slike not in", values, "slike");
            return (Criteria) this;
        }

        public Criteria andSlikeBetween(Integer value1, Integer value2) {
            addCriterion("slike between", value1, value2, "slike");
            return (Criteria) this;
        }

        public Criteria andSlikeNotBetween(Integer value1, Integer value2) {
            addCriterion("slike not between", value1, value2, "slike");
            return (Criteria) this;
        }

        public Criteria andScollectIsNull() {
            addCriterion("scollect is null");
            return (Criteria) this;
        }

        public Criteria andScollectIsNotNull() {
            addCriterion("scollect is not null");
            return (Criteria) this;
        }

        public Criteria andScollectEqualTo(Integer value) {
            addCriterion("scollect =", value, "scollect");
            return (Criteria) this;
        }

        public Criteria andScollectNotEqualTo(Integer value) {
            addCriterion("scollect <>", value, "scollect");
            return (Criteria) this;
        }

        public Criteria andScollectGreaterThan(Integer value) {
            addCriterion("scollect >", value, "scollect");
            return (Criteria) this;
        }

        public Criteria andScollectGreaterThanOrEqualTo(Integer value) {
            addCriterion("scollect >=", value, "scollect");
            return (Criteria) this;
        }

        public Criteria andScollectLessThan(Integer value) {
            addCriterion("scollect <", value, "scollect");
            return (Criteria) this;
        }

        public Criteria andScollectLessThanOrEqualTo(Integer value) {
            addCriterion("scollect <=", value, "scollect");
            return (Criteria) this;
        }

        public Criteria andScollectIn(List<Integer> values) {
            addCriterion("scollect in", values, "scollect");
            return (Criteria) this;
        }

        public Criteria andScollectNotIn(List<Integer> values) {
            addCriterion("scollect not in", values, "scollect");
            return (Criteria) this;
        }

        public Criteria andScollectBetween(Integer value1, Integer value2) {
            addCriterion("scollect between", value1, value2, "scollect");
            return (Criteria) this;
        }

        public Criteria andScollectNotBetween(Integer value1, Integer value2) {
            addCriterion("scollect not between", value1, value2, "scollect");
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