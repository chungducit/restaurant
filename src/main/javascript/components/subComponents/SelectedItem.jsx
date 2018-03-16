import React from 'react';

class SelectedItem extends React.Component {

    constructor(props) {
        super(props);
        this.handleSelectedItem = this.handleSelectedItem.bind(this);
    }

    handleSelectedItem () {
        this.props.onClickSelectedItem(this.props.item);
    }

    render() {
      let item = this.props.item;
      return (
        <div className="food col-4" onClick={this.handleSelectedItem}>
            <div className="food-inner">
            <div className="f-name">{item.name}</div>
            <div className="f-quan">SL : {item.quantity}</div>
            <div className="f-price">{item.price}</div>
            </div>
        </div>
      );
    }
  
}

  
export default SelectedItem;