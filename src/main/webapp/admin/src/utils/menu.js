import storage from '@/utils/storage'
const menu = {
    list() {
        if(storage.get("menus")) {
            return eval('(' + storage.get("menus")+ ')');
        } else {
            return null;
        }
    }
}
export default menu;
