import React from 'react';
import "whatwg-fetch";
import RootCategoryManager from "./RootCategoryManager.jsx";
import SecondCategoryManager from "./SecondCategoryManager.jsx";
import SubItemManager from "./SubItemManager.jsx";
import SelectedItemManager from "./SelectedItemManager.jsx";
import PayManager from "./PayManager.jsx";

class ItemManager extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
        ItemInfo : [],
        selectRootCategory : 0,
        selectSecondCategory : 0,
        rootCategories : {},
        items : [],
        selectedItems : []
    };
    this.handleSelectRootCategory = this.handleSelectRootCategory.bind(this);
    this.handleSelectSecondCategory = this.handleSelectSecondCategory.bind(this);
    this.handleSelectItem = this.handleSelectItem.bind(this);
  }

  handleSelectRootCategory (category) {
    this.setState({ selectRootCategory : category.id });
    this.setState({ rootCategories : category });
    this.handleSelectSecondCategory(category.cateList[0]);
  }

  handleSelectSecondCategory (subCategory) {
    this.setState({ selectSecondCategory : subCategory.id });
    this.setState({ items : subCategory.itemList });
  }

  handleSelectItem(item) {
      let selectedItems = this.state.selectedItems;
      let checkExist = selectedItems.find((i) => i.id == item.id );
      
      if (checkExist) {
        checkExist.quantity++;
      } else {
        item['quantity'] = 1;
        selectedItems.push(item);
      }

      this.setState({ selectedItems : selectedItems });
      this.props.onSelectItem(selectedItems);
  }

  componentDidMount () {
    fetch('/api/v1/getitems')
    .then(response => response.json())
    .then(json => {
        this.setState({ ItemInfo : json });
        let firstEl = json[0];
        this.setState({ selectRootCategory : firstEl.id });
        this.setState({ rootCategories : firstEl });
        this.setState({ selectSecondCategory : firstEl.cateList[0].id });
        this.setState({ items : firstEl.cateList[0].itemList });
    });
  }

  render() {
    return (
      <div className="foods-container row no-gutters">
        <div className="foods-list col-6">
          <RootCategoryManager category={this.state.ItemInfo}
                               selected={this.state.selectRootCategory}
                               onSelectRootCategory={this.handleSelectRootCategory}/>
          <SecondCategoryManager category={this.state.rootCategories}
                          selected={this.state.selectSecondCategory}
                          onSelectSecondCategory={this.handleSelectSecondCategory}/>
          <SubItemManager items={this.state.items}
                          onSelectItem={this.handleSelectItem}/>
        </div>
        <div className="foods-selected col-6">
            <SelectedItemManager items={this.state.selectedItems}
                                 onSelectItem={this.handleSelectItem}/>
            <PayManager items={this.state.selectedItems}/>
        </div>
        
      </div>
    );
  }

}

export default ItemManager;