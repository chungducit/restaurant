import React from 'react';

class Item extends React.Component {

    constructor(props) {
        super(props);

        this.handleSelectItem = this.handleSelectItem.bind(this);
    }

    handleSelectItem () {
        this.props.onClickItem(this.props.item);
    }

    render() {
      let item = this.props.item;
      return (
          <div className="food col-4" onClick={this.handleSelectItem}>
            <div className="food-inner">
              <div className="f-name">{item.name}</div>
              <div className="f-price">{item.price}</div>
            </div>
          </div>
      );
    }
  
}

  
export default Item;