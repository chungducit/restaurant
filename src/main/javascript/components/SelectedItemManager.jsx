import React from 'react';
import SelectedItem from "./subComponents/SelectedItem.jsx";

class SelectedItemManager extends React.Component {

  constructor(props) {
    super(props);
    this.handleSelectedItem = this.handleSelectedItem.bind(this);
  }

  handleSelectedItem (item) {
    this.props.onSelectItem(item);
  }

  render() {
    if (this.props.items.length) {
        let rows = [];
        this.props.items.forEach(item => {
            rows.push(<SelectedItem key={item.id} 
                                    item={item}
                                    onClickSelectedItem={this.handleSelectedItem}/>);
        });
    
        return (
          <div className="row no-gutters">
            {rows}
          </div>
        );
    } else {
        return null;
    }
  }

}

export default SelectedItemManager;