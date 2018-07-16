package com.choe.springboottest.jpa.repositorys;

// 添加注解，区别于我们定义的具体业务域
//@NoRepositoryBean
//public class CustomRepositoryImpl<T,ID extends Serializable> extends SimpleJpaRepository<T,ID> implements CustomRepository<T,ID> {
//
//    private EntityManager em;
//    private JpaEntityInformation<T, ?> entityInformation;
//
//    public CustomRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
//        super(entityInformation, entityManager);
//        this.entityInformation = entityInformation;
//        this.em = entityManager;
//    }
//
//    public CustomRepositoryImpl(Class<T> domainClass, EntityManager em) {
//        this(JpaEntityInformationSupport.getEntityInformation(domainClass, em), em);
//    }
//
//    @Override
//    public T get(T t) {
//
//        return (T) findOne(t, true);
//    }
//
//    @Override
//    public List<T> findAll(T t) {
//        return (List<T>) findOne(t, false);
//    }
//
//    @Override
//    public Integer count(T t) {
//        return null;
//    }
//
//    @Override
//    public void updateInBatch(T t) {
//
//
//    }
//
//    @Override
//    public void deleteByOther(T t) {
//
//    }
//
//    private Object findOne(T t, boolean isReturnOne) {
//        Map<String, Object> notNullFileds = getNotNullFileds(t);
//        String sql = null;
//        if (isReturnOne){
//            sql = buildGetSql(notNullFileds,0L,1);
//           return  this.em.createQuery(sql,t.getClass());
//        }else {
//            sql = buildGetSql(notNullFileds,null,null);
//           return  this.em.createQuery(sql,t.getClass());
//        }
//    }
//
//
//    private String buildGetSql(Map<String , Object> map,Long startRow, Integer limitRows) {
//        String selectSql = "select * from " + this.entityInformation.getEntityName() + "where 1 = 1";
//        for (String key : map.keySet()){
//            Object value = map.get(key);
//            selectSql += " and " + key +" = ";
//            if (value instanceof Number){
//                selectSql += value;
//            }else if (value instanceof String){
//                selectSql += "'"+value+"'";
//            }
//        }
//        if (startRow != null && startRow > 0 && limitRows != null && limitRows > 0){
//            selectSql += " limit "+startRow +","+limitRows;
//        }
//        return selectSql;
//    }
//
//    private String buildCountSql() {
//
//        return "";
//    }
//
//    private String buildUpdateSql() {
//
//        return "";
//    }
//
//    private String buildDeleteSql() {
//
//        return "";
//    }
//
//
//    public static void main(String[] args) throws IllegalAccessException {
//        JPAStudent jpaStudent = new JPAStudent();
//        jpaStudent.setId(1L);
//        jpaStudent.setHeight(222);
//        jpaStudent.setStudentName("xxxxx");
//        Map<String, Object> notNullFileds = getNotNullFileds(jpaStudent);
//        System.out.println(notNullFileds);
//    }
//
//    private static Map<String,Object> getNotNullFileds(Object object){
//        Map<String,Object> paramMap = null;
//        try {
//            Class stuCla = (Class) object.getClass();// 得到类对象
//            Field[] fs = stuCla.getDeclaredFields();//得到属性集合
//            paramMap = new HashMap<>();
//            for (Field f : fs) {//遍历属性
//                f.setAccessible(true); // 设置属性是可以访问的(私有的也可以)
//                Object val = f.get(object);// 得到此属性的值
//                System.out.println(f.getName() +"==="+val);
//                if (val != null){
//                    // 获取注解
//                    Annotation[] annotations = f.getAnnotations();
//                    if (annotations != null && annotations.length > 0){
//                        for (int i = 0 ; i < annotations.length; i++){
//                            if (annotations[i] instanceof Column){
//                                Column column = (Column) annotations[i];
//                                String name = column.name();
//                                paramMap.put("".equals(name)?f.getName():name,val);
//                                break;
//                            }
//                            if (i == annotations.length-1){
//                                paramMap.put(f.getName(),val);
//                            }
//                        }
//                    }else {
//                        paramMap.put(f.getName(),val);
//                    }
//                }
//            }
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//
//        return paramMap;
//    }
//}
