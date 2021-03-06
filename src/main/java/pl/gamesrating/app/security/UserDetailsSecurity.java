package pl.gamesrating.app.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.gamesrating.app.model.Role;
import pl.gamesrating.app.model.User;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UserDetailsSecurity implements UserDetails {
    private User user;

    public UserDetailsSecurity(final User _user) {
        this.user = _user;
    }

    public UserDetailsSecurity() {
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        final Set<GrantedAuthority> _grntdAuths = new HashSet<GrantedAuthority>();
        Set<Role> _roles = null;

        if (user != null) {
            _roles = user.getRoles();
        }

        if (_roles != null) {
            for (Role _role : _roles) {
                _grntdAuths.add(new SimpleGrantedAuthority(_role.getRole()));
            }
        }
        return _grntdAuths;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        if (this.user == null) {
            return null;
        }
        return this.user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.user.getActive() > 0;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "UserDetailsSecurity [user=" + user + "]";
    }
}
