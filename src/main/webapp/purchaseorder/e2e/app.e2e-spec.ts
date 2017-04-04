import { PurchaseorderPage } from './app.po';

describe('purchaseorder App', function() {
  let page: PurchaseorderPage;

  beforeEach(() => {
    page = new PurchaseorderPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
