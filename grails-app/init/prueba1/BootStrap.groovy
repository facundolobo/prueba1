package prueba1

import com.mycompany.myapp.Role
import com.mycompany.myapp.User
import com.mycompany.myapp.UserRole


class BootStrap {

    def init = { servletContext ->
        createRoles()
        
        createUsers()
    }
    def destroy = {
        
    }
    private static void createRoles() throws Exception {
        createRol('ROLE_ADMIN')
        createRol('ROLE_ADMIN_USUARIOS')
        createRol('ROLE_ADMIN_CATALOGOS')
    }
    
    private static void createRol(String authority) {
        def role = new Role(authority: authority)
        
        role.save(failOnError: true)
    }
        private void createUsers() throws Exception {
        createUser('admin', '12345', 'ROLE_ADMIN')
    }
    
    private void createUser(String username, String password,String role) 
    throws Exception {
        
        def user = new User(username: username, password: password)
        user.save(failOnError: true)
        
        def elRol = Role.findByAuthority(role)
        if(!elRol){
            elRol= createRol(role)
        }
        new UserRole(user: user, role: elRol).save(failOnError: true)
    }
        
}
