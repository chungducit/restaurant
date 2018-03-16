import React from 'react';
import Item from "./subComponents/Item.jsx";

class SubItemManager extends React.Component {

  constructor(props) {
    super(props);
    this.handleSelectItem = this.handleSelectItem.bind(this);
  }

  handleSelectItem (item) {
    this.props.onSelectItem(item);
  }

  render() {
    let rows = [];
    let notify = <div>Không có sản phẩm tại danh mục này</div>;
    let len = this.props.items.length;
    this.props.items.forEach(item => {
    rows.push(<Item key={item.id} 
                    item={item} 
                    onClickItem={this.handleSelectItem} />);
    });

    return (
      <div className="row no-gutters">
        {len ? rows : notify}
      </div>
    );
  }

}

export default SubItemManager;