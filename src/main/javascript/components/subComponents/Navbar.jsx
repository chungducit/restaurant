import React from 'react';

class Navbar extends React.Component {
    render() {
        let _className = 'navbar ' + this.props.className;
        let left_nav = this.props.left_nav || <a className="navbar-brand">{this.props.title_nav}</a>;
        return (
            <nav className={_className}>
                {left_nav} {this.props.content}
            </nav>
        );
    }
  
}

  
export default Navbar;