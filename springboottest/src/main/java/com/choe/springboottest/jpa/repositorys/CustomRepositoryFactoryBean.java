package com.choe.springboottest.jpa.repositorys;

/**
 * @author cyk
 * @date 2018/7/16/016 09:04
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
//public class CustomRepositoryFactoryBean <T extends JpaRepository<T,ID> ,S,ID extends Serializable> extends JpaRepositoryFactoryBean<T ,S,ID > {
//
//
//    public CustomRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
//        super(repositoryInterface);
//    }
//
//
//
//    private class CustomRepositoryFactory extends JpaRepositoryFactory{
//
//        public CustomRepositoryFactory(EntityManager entityManager) {
//            super(entityManager);
//        }
//
//        @Override
//        protected <T, ID extends Serializable> SimpleJpaRepository<?, ?> getTargetRepository(RepositoryInformation information, EntityManager entityManager) {
//            return new CustomRepositoryImpl<T,ID>((Class<T>) information.getDomainType(),entityManager);
//        }
//
//        @Override
//        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
//            return CustomRepositoryImpl.class;
//        }
//    }
//}
