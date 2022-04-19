import React from 'react';
import {Route} from "react-router-dom";
import NoPermission from "../../common/error/NoPermission";
import {isAdmin} from "../App";


const PrivateAdminRoute = ({component: Component, authenticated, currentUser, ...rest}) => (
    <Route
        {...rest}
        render={props =>
            authenticated && isAdmin(currentUser) ? (
                <Component {...rest} {...props} />
            ) : (
                <NoPermission/>
            )
        }
    />
);

export default PrivateAdminRoute;
