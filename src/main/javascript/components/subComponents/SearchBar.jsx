import React from 'react';

class SearchBar extends React.Component {
    constructor (props) {
        super(props);
        this.handleFilterTextChange = this.handleFilterTextChange.bind(this);
    }

    handleFilterTextChange (e) {
        this.props.onFilterTextChange(e.target.value);
    }

    render() {
        return (
            <form className="form-inline">
                <input className="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" 
                       onChange={this.handleFilterTextChange}
                       value={this.props.filterText} />
            </form>
        );
    }
}

  
export default SearchBar;